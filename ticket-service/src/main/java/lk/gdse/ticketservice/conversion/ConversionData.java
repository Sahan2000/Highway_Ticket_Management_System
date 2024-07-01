package lk.gdse.ticketservice.conversion;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
