package edu.utn.phones.Projection;

import java.util.Date;

public interface CallProjection {

    String getNumberOriginCall();
    String getNumberDestinationCall();
    Date getDateCall();
}
