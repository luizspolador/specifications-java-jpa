package br.com.spolador.consultasdinamicas.dto;

import lombok.Getter;

@Getter
public class SearchRequestDto {
    private String column;
    private String value;
    private Operation operation;
    private String joinTable;

    public enum Operation{
        EQUAL, LIKE, IN, GREATER_THAN, LESS_THAN, BETWEEN, JOIN;
    }
}
