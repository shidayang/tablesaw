package com.github.lwhite1.tablesaw.filtering.text;

import com.github.lwhite1.tablesaw.api.CategoryColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.columns.ColumnReference;
import com.github.lwhite1.tablesaw.filtering.ColumnFilter;
import com.github.lwhite1.tablesaw.util.Selection;

import javax.annotation.concurrent.Immutable;

/**
 * A filtering that selects cells in which all text is uppercase
 */
@Immutable
public class TextIsLongerThan extends ColumnFilter {

    private int length;

    public TextIsLongerThan(ColumnReference reference, int length) {
        super(reference);
        this.length = length;
    }

    @Override
    public Selection apply(Table relation) {
        Column column = relation.column(columnReference().getColumnName());
        CategoryColumn textColumn = (CategoryColumn) column;
        return textColumn.isLongerThan(length);
    }
}