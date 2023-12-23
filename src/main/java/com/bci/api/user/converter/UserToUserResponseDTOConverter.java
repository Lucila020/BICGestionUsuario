package com.bci.api.user.converter;

import com.bci.api.user.dto.PhoneDTO;
import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.dto.UserResponseDTO;
import com.bci.api.user.entity.Phone;
import com.bci.api.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserResponseDTOConverter implements Converter<User, UserResponseDTO> {

    @Override
    public UserResponseDTO convert(User source) {
        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setActive(source.getIsActive());
        userResponse.setId(source.getId());
        userResponse.setCreated(source.getCreated().toString());
        userResponse.setModified(source.getModified().toString());
        userResponse.setLastLogin(source.getLastLogin().toString());
        userResponse.setToken(source.getToken());
        userResponse.setUser(getUser(source));
        return userResponse;
    }

    private UserDataDTO getUser(User sourse){
        UserDataDTO user = new UserDataDTO();
        user.setEmail(sourse.getEmail());
        user.setPassword(sourse.getPassword());
        user.setName(sourse.getName());
       user.setPhones(getListOfPhone(sourse.getPhones()));
        return user;
    }

    private List<PhoneDTO> getListOfPhone(List<Phone> phones) {

        List<PhoneDTO> listPhone = new ArrayList<>();
        phones.stream()
                .forEach(phone -> {
                    PhoneDTO phoneUser = new PhoneDTO();
                    phoneUser.setCityCode(phone.getCityCode());
                    phoneUser.setContryCode(phone.getContryCode());
                    phoneUser.setNumber(phone.getNumber());
                    listPhone.add(phoneUser);
                });
        return listPhone;
    }
}
