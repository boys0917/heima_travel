package travel.domain;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 20:16
 */
public class PageBean<T> {
    private int totalCount;//总记录数
    private int totalPage;//总页码
    private int currentPage;//当前页码
    private int pageSize;//一页显示条数
    private List<T> list;//每页显示的数据的集合

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}