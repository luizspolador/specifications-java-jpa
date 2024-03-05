package br.com.spolador.consultasdinamicas.dto;

import lombok.Getter;

@Getter
public class SearchRequestDto {
    private String column;
    private String value;
    private Operation operation;

    public enum Operation{
        EQUAL, LIKE, IN;
    }
}
