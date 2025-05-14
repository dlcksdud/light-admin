package com.dreamsecurity.lightadminback.aop.annotation;

import com.dreamsecurity.lightadminback.common.enums.EventType;
import java.lang.annotation.*;

/**
 * custom annotation 정의
 * aop에서 어떤 메서드에 Audit을 남길지 지정
 * 
 */
@Target(ElementType.METHOD) // AditLog annotation을 어디에 붙일 수 있는 지 정의 : METHOD에만 붙일 수 있음
@Retention(RetentionPolicy.RUNTIME) // Annotaion 정보를 언제까지 유지할지 : RUNTIME 은 실행중에도 JVM 메모리에 남아서 리플렉션이나 aop로 읽을 수 있음
@Documented // Javadoc 같은 문서화 도구에 자동 포함
public @interface AuditLog {
    EventType eventType();
    String page();
}
