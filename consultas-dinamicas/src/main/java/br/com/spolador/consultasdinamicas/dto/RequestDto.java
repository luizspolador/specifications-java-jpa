package br.com.spolador.consultasdinamicas.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestDto {
    private List<SearchRequestDto> searchRequestDto;
    private GlobalOperator globalOperator;

    public enum GlobalOperator{
        AND, OR;
    }
}
