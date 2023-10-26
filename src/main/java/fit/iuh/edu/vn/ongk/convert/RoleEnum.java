package fit.iuh.edu.vn.ongk.convert;

import fit.iuh.edu.vn.ongk.enums.Roles;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleEnum implements AttributeConverter<Roles,Integer> {

    @Override
    public Integer convertToDatabaseColumn(Roles roles) {
        if(roles == null)
        {
            return null;
        }
        return roles.getValues();
    }

    @Override
    public Roles convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;
        }
        return Stream.of(Roles.values())
                .filter(c->c.getValues() == integer)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
