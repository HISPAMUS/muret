package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

/**
 * Used as RequestBody parameter because we get errors using the generics (JSON parse error)
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/2/21
 */
public class LongArray extends NumberArray<Long>{
    public LongArray(List<Long> numbers) {
        super(numbers);
    }

    public LongArray() {
    }
}
