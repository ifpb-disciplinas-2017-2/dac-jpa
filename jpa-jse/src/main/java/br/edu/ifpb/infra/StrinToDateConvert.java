package br.edu.ifpb.infra;

import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/02/2018, 09:46:20
 */
@Converter(autoApply = false)
public class StrinToDateConvert implements  AttributeConverter<String, Date>{

    @Override
    public Date convertToDatabaseColumn(String attribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String convertToEntityAttribute(Date dbData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
