package com.acikgozKaan.LibraryAPI.core.utilies;

import com.acikgozKaan.LibraryAPI.core.result.Result;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true,Msg.CREATED,"201",data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false,Msg.VALIDATE_ERROR,"400",data);
    }

    public static <T> ResultData<T> updated(T data) {
        return new ResultData<>(true,Msg.UPDATED,"200",data);
    }

    public static <T> ResultData<T> deleted(T data) {
        return new ResultData<>(true,Msg.DELETED,"200",data);
    }

    public static Result notFound(String msg) {
        return new Result(false,msg,"404");
    }

    public static <T> ResultData<T> ok(T data) {
        return new ResultData<>(true, Msg.OK,"200",data);
    }

}
