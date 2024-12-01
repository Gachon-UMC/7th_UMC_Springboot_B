package umc.umc.study.apiPayload.code;

import umc.umc.study.apiPayload.code.status.ErrorReasonDTO;
import umc.umc.study.apiPayload.code.status.ReasonDTO;

public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}