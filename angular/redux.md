# Redux pattern applied with *ngrx* in Angular
*(Taken from https://medium.com/frontend-fun/angular-ngrx-a-clean-and-clear-introduction-4ed61c89c1fc)*

##Step 1: configuration
- Install libraries: `npm install @ngrx/core @ngrx/store @ngrx/effects @ngrx/store-devtools @ngrx/router-store --save`
- Create folder `store` under `app`, and inside: `actions`, `effects`, `reducers`, `selectors` and `state`.

##Step 2: model
Create a model folder with:
- for each domain class:
  - interfaces equivalent to the domain and used to communicate with the backend with a REST API
    > e.g. `export interface Product {id: number; name: string; price: number;}`
  - interfaces that will be stored in the state (*state* = current state of the domain objects of the application)
    > e.g. `export interface ProductState {products: Product[]; selectedProduct: Product;}`
  - constant with the initial state of each state interface:
    > e.g. `export const initialProductState: ProductState = {products: null, selectedProduct: null};`
- a global or root application state containing all state interfaces and the router state      
    > e.g. `export interface AppState {router?: RouterReducerState; products: ProductState; }` (add here all other states)
    
##Step 3: selectors
Given the global information rooted in the state in the store, selectors will extract a part or slice of it. 
A selector is similar to a getter from the root state.
> e.g. 
> ```
> const selectProducts = (state: AppState) => state.products;
> export const selectProductList = createSelector (
>   selectProducts,
>   (state: UserState) => state.products
> ); 
> export const selectSelectedProduct = createSelector (
>   selectProducts,
>   (state: ProductState) => state.selectedProduct
> ); 
> ```


    
##Step 4: actions
Define an enum with all action descriptions:
> e.g. 
> ```
> export enum EProductActions {
>  GetProducts = '[Product] Get products',
>  GetProductsSuccess = '[Product] Get products success',
>  GetProductsFailed = '[Product] Get products failed'
>  GetProduct = '[Product] Get one product',
>  GetProductSuccess = '[Product] Get one product success',
>  GetProductFailed = '[Product] Get one product success',
> }
>``` 
> where `[Product]` is just a means to later distinguish in logs the product related actions 

Then, action classes must implement the interface `Action`. 

There will be actions without parameters (e.g. retrieve all products):

> e.g. 
> ```
> export class GetProducts implements Action {
>  public readonly type = EProductActions.GetProducts;
> }
>```

and actions with parameters (or payload):

> e.g. notify the frontend with a successfully response with the retrieved product from the previous example
> ```
> export class GetProductsSucess implements Action {
>  public readonly type = EProductActions.GetProductsSuccess;
>    constructor (public payload: Product[]);
> }
>```

> e.g. send the request to the backend to retrieve a specific product given its ID 
> ```
> export class GetProduct implements Action {
>  public readonly type = EProductActions.GetProduct;
>    constructor (public payload: number);
> }
>```

> e.g. and again notify the frontend with a successful specific product retrieval 
> ```
> export class GetProductSuccess implements Action {
>  public readonly type = EProductActions.GetProductSuccess;
>    constructor (public payload: Product);
> }
>```


Finally this actions must be exported:
> e.g. 
> ```
> export enum ProductActions {
>  GetProducts | GetProductsSuccess | GetProductsFailed
>  | GetProduct | GetProductSuccess | GetProductFailed
> }
>``` 

##Step 5: reducers and effects
The reducers and effects will handle the response to actions: 
- reducers will be *pure* functions, i.e., functions that will not have any side effect
- effects will include non *pure* functions and HTTP REST API calls

### 5.1 Reducers
They will return a clone of the previous state with the new information appended (see operator `...`, the previous state will be not changed.

A reducer will be created for each domain object with all responses of success and failures. 

> e.g. 
> ```
> export const productReducers = (
>   state = initialProductState,
>   action = ProductActions
> ): ProductState => {
>     switch (action.type) {
>       case EProductActions.GetProductsSuccess: {
>         return {
>           ...state,
>           products: action.payload
>         };
>       }
>       case EProductActions.GetProductSuccess: {
>         return {
>           ...state,
>           selectedProduct: action.payload
>         };
>       }
>       default:
>         return state;
>   }
> };      
**TODO Add failure reducers here**

Finally, all reducers will be included in the root `appReducers` constant:

> ```
> export const appReducers: ActionReducerMap<AppState, any> = (
>   router: routerReducer,
>   products: productReducers
> };
> ```

### 5.2 Effects
Basically we will include here all calls to HTTP REST API. The usual structure will be:

> e.g.
> ```
> @Injectable()
> export class ProductEffects {
>   constructor(
>     private _productService: ProductService,
>     private _actions$: Actions,
>     private _store: Store<AppState>
>   ) {}
> 
>   @Effect()
>   getProducts$ = this._actions$.pipe(
>     ofType<GetProducts>(EProductActions.GetProducts),
>     switchMap(() => this._productService.getProducts()),
>     switchMap((productHttp: ProductHttp) => {
>       return of(new GetProductsSuccess(productHttp.products));
>     })
>   );
> 
>   @Effect()
>   getProduct$ = this._actions$.pipe(
>     ofType<GetProduct>(EProductActions.GetProduct),
>     map(action => action.payload),
>     withLatestFrom(this._store.pipe(select(selectProductList))),
>     switchMap(([id, products]) => {
>       const selectedProduct = products.filter(product => product.id === +id)[0];
>       return of(new GetProductSuccess(selectedProduct));
>     })
>   );
> }
> ```
>
> where ```productService``` will be the service in charge of the HTTP API REST calls

## 6 View and controller
### 6.1 Visual rendering of data
In order visually render to use the information stored in the state:
- when component is initialized (```ngOnInit```) send the *action* to get the requested data.
- the data (```products$``` observable in the example below), is just a slice of the state using a *selector*. 

> e.g.
> ```
> export class ProductsComponent implements OnInit {
>  products$ = this.store.pipe(select(selectProductList));
>
>  constructor(private store: Store<AppState>, private router: Router) {}
>
>  ngOnInit() {
>    this.store.dispatch(new GetProducts());
>  }
> }
> ``` 

In the HTML use the usual operators:
> e.g.
> ```
> "products$ | async"
> ``` 

### 6.2 Interaction
We can send a router navigation request, e.g. ```this.router.navigate(['product', id]);```,
or send an action with ```this.store.dispatch(new SOME_ACTION());``` 
