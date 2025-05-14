package com.dreamsecurity.lightadminback.common.exception;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import com.dreamsecurity.lightadminback.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.stream.Collectors;

/**
 * GlobalExceptionHandler
 * Exception global 처리
 *
 * @author smmoon
 * @since 2025-04-04
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Request Argument Validation Exception 공통 처리
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        log.error("Validation failed: {}", message);
        return new ResponseEntity<>(ResponseDTO.of(ErrorCode.RUNTIME_EXCEPTION, message),
                ErrorCode.RUNTIME_EXCEPTION.getStatus());
    }
    /**
     * 사용자 정의 Exception 처리
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ResponseDTO> handleBaseException(BaseException e){
        log.error("Business error: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDTO.of(e.getErrorCode(), e.getMessage()),
                e.getErrorCode().getStatus());
    }

    /**
     * Missing Request Parameter Exception 공통 처리
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseDTO> handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        log.error("Missing request parameter: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDTO.of(ErrorCode.MISSING_PARAMETER, e.getMessage()),
                ErrorCode.RUNTIME_EXCEPTION.getStatus());
    }

    /**
     * Access Denied Exception 공통 처리
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseDTO> handleAccessDeniedException(AccessDeniedException e){
        log.error("Access Denied: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDTO.of(ErrorCode.ACCESS_DENIED_EXCEPTION, e.getMessage()),
                ErrorCode.ACCESS_DENIED_EXCEPTION.getStatus());
    }

    /**
     * 그외 exception 처리
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException(Exception e, HttpServletRequest request){
        log.error("[{} {}] Unhandled exception: {}", request.getMethod(), request.getRequestURI(), e.getMessage(), e);
        return new ResponseEntity<>(ResponseDTO.of(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage()),
                ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
    }

}
