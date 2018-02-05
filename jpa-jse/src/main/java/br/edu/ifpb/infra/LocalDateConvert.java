package br.edu.ifpb.infra;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/02/2018, 09:34:04
 */
@Converter(autoApply = true)
public class LocalDateConvert implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }

        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }

        return dbData.toLocalDate();
    }

}
