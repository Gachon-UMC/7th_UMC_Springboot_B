package umc.study.apiPayload.code.status;


import umc.study.apiPayload.code.ReasonDTO;

public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}
