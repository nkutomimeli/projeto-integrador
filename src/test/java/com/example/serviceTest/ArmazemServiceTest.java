package com.example.serviceTest;

import com.example.demo.dto.ArmazemDTO;
import com.example.demo.dto.ListaArmazemDTO;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.service.ArmazemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;

public class ArmazemServiceTest {

    private EstoqueRepository estoqueRepository;

    @Test
    public void deveVerificarEstoquePorArmazem() {

        List<ListaArmazemDTO> listaInterandoArmazemTeste = new ArrayList<>();
        ArmazemDTO armazemDTO = new ArmazemDTO(1L, listaInterandoArmazemTeste);

        ListaArmazemDTO listaArmazemDTO1 = ListaArmazemDTO.builder()
                .armazem_id(3L)
                .totalQuantidade(100)
                .build();

        listaInterandoArmazemTeste.add(listaArmazemDTO1);

        EstoqueRepository mock = Mockito.mock(EstoqueRepository.class);
        ArmazemService armazemService = new ArmazemService(mock);

        //Mockito.when(mock.getEstoqueByArmazem(anyString())).thenReturn(listaInterandoArmazemTeste);

        //assertEquals(armazemDTO.getListaArmazem().size(),1);

    }

}
