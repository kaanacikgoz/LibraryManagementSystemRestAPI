package com.acikgozKaan.LibraryAPI.core.utilies;

import com.acikgozKaan.LibraryAPI.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true,Msg.CREATED,"201",data);
    }

}
