package web;

import java.io.IOException;

public interface ConsumerEx<A> {

    void accept(A t) throws IOException;

}

