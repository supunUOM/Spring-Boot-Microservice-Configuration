//** DEPENDENCY **//
<dependency> 
        <groupId>org.modelmapper</groupId> 
        <artifactId>modelmapper</artifactId> 
        <version>3.1.1</version> 
</dependency>

//** CONFIG **//
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}


//** MAPPING **//
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MappingHelper {

    private final ModelMapper modelMapper;

    public <S, T> List<T> mapToDTOList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T mapToDTO(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    //Normal way for List mapping
    List<UserDTO> dtos = users
         .stream()
         .map(user -> modelMapper.map(user, UserDTO.class))
         .collect(Collectors.toList());
}

