# Angular
cd angular
#hashing to force cache clean
node_modules/@angular/cli/bin/ng build --output-hashing=all --aot --prod --base-href=/muret/ --deploy-url=https://muret.dlsi.ua.es/muret/
cd ..
cd angular/dist/angular
scp -r * alimbo:/web/muret/docs/muret/
cd -


