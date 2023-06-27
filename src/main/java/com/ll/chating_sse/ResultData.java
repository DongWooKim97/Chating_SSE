package com.ll.chating_sse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResultData<T> {

    private String resultCode;
    private String msg;
    private T data;
}
