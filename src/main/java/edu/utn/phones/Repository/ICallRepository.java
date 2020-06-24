package edu.utn.phones.Repository;

import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.User;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICallRepository extends JpaRepository<Call, Integer> {


    List<Call> findTop3ByLineCallOwnerLineOrderByDateCallDesc(User u);


        /*Se supone las llamadas se ingresan con solo unos pocos datos pero en la base de datos se calculan
        * por lo que la ciudad ya estara cargada al momento de lleerla*/
    List<Call> findByCityDestinationCallPrefixBetween(String minPrefix, String maxPrefix);
    List<Call> findByCityOriginCallPrefixBetween(String minPrefix, String maxPrefix);

    //Los primeros 2 son city origin, y los otros dos para city destination, en el service se pasa a ambos los mismos
    List<Call> findByCityOriginCallPrefixBetweenAndCityDestinationCallPrefixBetween(String minPrefix, String maxPrefix, String min2, String max2);
}
