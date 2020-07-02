package edu.utn.phones.Projetions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public interface CallProjection {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String getNumberOrigin();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String getCityOrigin();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String getNumberDestination();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String getCityDestination();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Float getPriceTotal();
    @JsonInclude(JsonInclude.Include.NON_NULL)
     Integer getDurationCall();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime getDateCall();
    @JsonInclude(JsonInclude.Include.NON_NULL)
     Integer getIdUser();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer getCant();



     void setNumberOrigin(String number);

     void setCityOrigin(String number);

    void setNumberDestination(String number );

    void setCityDestination(String cityDestination);

    void setPriceTotal(Float priceTotal);

    void setDurationCall(Integer durationCall);

    void setDateCall(LocalDateTime dateCall);

    void setIdUser(Integer idUser);
     void setCant(Integer cant);


}
