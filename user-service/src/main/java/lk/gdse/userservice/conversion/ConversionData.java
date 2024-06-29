package lk.gdse.userservice.conversion;

import lk.gdse.userservice.dto.UserDTO;
import lk.gdse.userservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConversionData {
    private final ModelMapper modelMapper;
    public <S, T> T mapTo(S source, Class<T> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    public <S, T> List<T> mapTo(List<S> sourceList, Class<T> destinationClass) {
        return sourceList
                .stream()
                .map(source -> modelMapper.map(source, destinationClass))
                .collect(Collectors.toList());
    }
}
