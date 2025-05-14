package com.dreamsecurity.lightadminback.dto;

import com.dreamsecurity.lightadminback.common.util.PaginationUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * PagingDTO
 *
 * @author smmoon
 * @since 2025-04-11
 */
@Getter
@Setter
public class PagingDTO {

    private int page; // 현재 페이지 번호
    private int rowsPerPage; // 페이지 당 출력할 데이터 개수 // recordSize
    private int pageSize; // 화면 하단에 출력할 페이지 사이즈 1~10
    private String order; // 정렬방식 : asc / desc
    private String orderBy; // 정렬컬럼 ex) name, id, state..
    @NotNull
    private String currentPage;

    // 검색 기능
    // 관리자 목록 검색
    private String role;
    private String groupId;
    private String userId;
    private String userName;
    private String state;

    // 계정 목록 검색
    private String account;

    // 계정별 키 목록 검색
    private String address;
    private String alias;
    private String publicKey;

    // 로그 검색
    private String pageName; //페이지
    private String creator; // 관리자 아이디

    // 공통 날짜 검색
    private String createDate_str;
    private String createDate_end;

    // Pagination 정보
    private PaginationUtil paginationUtil;


    /*
    [생성자]
    객체가 생성되는 시점의 기본값
     */
    public PagingDTO() {
        this.page = 0; // 현재 페이지 번호
        this.rowsPerPage = 10; // 페이지 당 출력할 데이터 개수
        this.pageSize = 10; // 화면 하단에 1~10 까지 보이게.
        this.order = "DESC";
        this.orderBy = "CREATE_DATE";
    }


    // return (page - 1) * rowsPerPage
    /*
    mariadb에서 LIMIT 구문
    - 첫 번째 파라미터 : 시작 위치( 몇 번 째 데이터부터 가져올 것인지)
    - 두 번째 파라미터 : 시작 위치를 기준으로 가지고 올 데이터의 개수

    ex) 현재 페이지 번호(page) = 1
        페이지당 출력할 데이터의 개수(rowsPerPage) = 5
        (1 - 1) * 5 = 0

       쿼리는 LIMIT 20(20번째 데이터부터 가지고 올 것), 10(시작 위치를 기준으로 가지고 올 데이터의 개수)

     */
    public int getOffset() {
        return (page - 1) * rowsPerPage;
    }

    @Override
    public String toString() {
        return "{" +
                "page=" + page +
                ", rowsPerPage=" + rowsPerPage +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", currentPage='" + currentPage + '\'' +
                ", role='" + role + '\'' +
                ", groupId='" + groupId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", createDate_str='" + createDate_str + '\'' +
                ", createDate_end='" + createDate_end + '\'' +
                ", state='" + state + '\'' +
                ", account='" + account + '\'' +
                ", address='" + address + '\'' +
                ", alias='" + alias + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", paginationUtil=" + paginationUtil +
                '}';
    }
}
