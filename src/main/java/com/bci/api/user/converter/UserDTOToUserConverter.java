package com.bci.api.user.converter;

import com.bci.api.user.dto.PhoneDTO;
import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.entity.Phone;
import com.bci.api.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class UserDTOToUserConverter implements Converter<UserDataDTO, User>{

    @Override
    public User convert(UserDataDTO source) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(source.getEmail());
        user.setName(source.getName());
        user.setPassword(source.getPassword());
        user.setLastLogin(new Date());
        user.setPhones(getListOfPhone(source.getPhones()));
        return user;
    }

    private List<Phone> getListOfPhone(List<PhoneDTO> phones) {

        List<Phone> listPhone = new ArrayList<>();
        phones.stream()
                .forEach(phone -> {
                    Phone phoneUser = new Phone();
                    phoneUser.setCityCode(phone.getCityCode());
                    phoneUser.setContryCode(phone.getContryCode());
                    phoneUser.setNumber(phone.getNumber());
                    listPhone.add(phoneUser);
                });
        return listPhone;
    }
}
