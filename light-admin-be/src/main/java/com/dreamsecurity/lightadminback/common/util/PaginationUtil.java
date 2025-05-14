package com.dreamsecurity.lightadminback.common.util;

import com.dreamsecurity.lightadminback.dto.PagingDTO;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * PaginationUtil
 *
 * @author smmoon
 * @since 2025-04-11
 */
@Getter
@ToString
@Slf4j
public class PaginationUtil {
    private int startRowNum;
    private int endRowNum;

    public PaginationUtil(PagingDTO pagingDTO) {
        startRowNum = (pagingDTO.getPage() + 1) * pagingDTO.getRowsPerPage() - (pagingDTO.getRowsPerPage() - 1);
        log.debug("startRowNum = {}", startRowNum);
        endRowNum = (pagingDTO.getPage() + 1) * pagingDTO.getRowsPerPage();
        log.debug("endRowNum = {}", endRowNum);
    }
}
