package aulaSpring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

//@RunWith(MockitoJUnitRunner.class) Junit4
@ExtendWith(MockitoExtension.class)
public class MockitoTeste {

    @Mock
    List<String> list;

    @Test
    public void primeiroTesteMockito(){
        // List<String> list = Mockito.mock(ArrayList.class);
        // O mesmo resultado se eu mockar usando annotation
        //classes mockadas retornam os valores defaults

        //cenario
        Mockito.when(list.size()).thenReturn(20);//decido qual valor ira retornar no when

        //execução
        int size = list.size();

        //validação
        Assertions.assertThat(size).isEqualTo(20);

        Mockito.verify(list, Mockito.times(1)).size();//verificar se o metodo foi chamado
        /*
        Mockito.verify(list, Mockito.never()).size();
        verificar se o metodo nao foi chamado
         */
    }

    @Test
    public void testeInOrder(){
        //execução
        list.size();
        list.add("");

        //validação
        InOrder inOrder = Mockito.inOrder(list);//Teste chamadas em ordem
        inOrder.verify(list).size();
        inOrder.verify(list).add("");
    }

}
