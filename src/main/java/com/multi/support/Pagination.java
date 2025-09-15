package com.multi.support;

public class Pagination {
    private final int page;         // 현재 페이지 (1-base)
    private final int size;         // 페이지 크기
    private final int total;        // 총 건수
    private final int totalPages;   // 총 페이지
    private final int block;        // 페이지 블록 크기(예: 5, 10)
    private final int startPage;    // 현재 블록 시작 페이지
    private final int endPage;      // 현재 블록 끝 페이지

    public Pagination(int page, int size, int total, int block) {
        this.page = Math.max(1, page);
        this.size = Math.max(1, size);
        this.total = Math.max(0, total);
        this.block = Math.max(1, block); // block 값도 음수나 0이 되지 않도록 추가했습니다.

        // 전체 페이지 수 계산
        this.totalPages = (int) Math.ceil((double) this.total / this.size);

        // 현재 블록의 시작 페이지 계산
        // ( (현재페이지 - 1) / 블록크기 ) * 블록크기 + 1
        this.startPage = ((this.page - 1) / this.block) * this.block + 1;

        // 현재 블록의 끝 페이지 계산
        int calculatedEndPage = this.startPage + this.block - 1;
        this.endPage = Math.min(calculatedEndPage, this.totalPages);
    }

    // --- Getter Methods ---
    // 외부에서 필드 값을 사용하기 위해 Getter를 추가하는 것이 일반적입니다.

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getBlock() {
        return block;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }
}
