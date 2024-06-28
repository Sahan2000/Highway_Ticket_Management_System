package lk.gdse.userservice.conversion;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConversionData {
    private final ModelMapper modelMapper;
    public <S, T> T mapTo(S source, Class<T> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }
}
