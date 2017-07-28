package xin.aliya.url.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T> implements Serializable {
    private List<T> list;
    private String statement;
    private int pageSize;
    private int totalRows;
    private int totalPages;
    private int currentPage;
}
