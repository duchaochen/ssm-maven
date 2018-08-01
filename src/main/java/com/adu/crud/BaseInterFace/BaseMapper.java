package com.adu.crud.BaseInterFace;

import java.util.List;

public interface BaseMapper<P,V> {
    void insertALL(P p) throws Exception;
    List<P> findALL(V v) throws Exception;
}
