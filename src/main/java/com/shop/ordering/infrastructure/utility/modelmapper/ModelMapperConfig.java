package com.shop.ordering.infrastructure.utility.modelmapper;

import com.shop.ordering.application.customer.query.CustomerOutput;
import com.shop.ordering.application.order.query.OrderDetailOutput;
import com.shop.ordering.application.order.query.OrderItemDetailOutput;
import com.shop.ordering.application.utility.Mapper;
import com.shop.ordering.domain.model.commons.FullName;
import com.shop.ordering.domain.model.customer.BirthDate;
import com.shop.ordering.domain.model.customer.Customer;
import com.shop.ordering.infrastructure.persistence.order.OrderItemPersistenceEntity;
import com.shop.ordering.infrastructure.persistence.order.OrderPersistenceEntity;
import io.hypersistence.tsid.TSID;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ModelMapperConfig {

    private static final Converter<FullName, String> fullNameToFirstNameConverter =
            mappingContext -> {
                FullName fullName = mappingContext.getSource();
                if (fullName == null) {
                    return null;
                }
                return fullName.firstName();
            };

    private static final Converter<FullName, String> fullNameToLastNameConverter =
            mappingContext -> {
                FullName fullName = mappingContext.getSource();
                if (fullName == null) {
                    return null;
                }
                return fullName.lastName();
            };

    private static final Converter<BirthDate, LocalDate> birthDateToLocalDateConverter =
            mappingContext -> {
                BirthDate birthDate = mappingContext.getSource();
                if (birthDate == null) {
                    return null;
                }
                return birthDate.value();
            };

    private static final Converter<Long, String> longToStringTSIDConverter =
            mappingContext -> {
                Long tsidAsLong = mappingContext.getSource();
                if (tsidAsLong == null) {
                    return null;
                }
                return new TSID(tsidAsLong).toString();
            };

    @Bean
    public Mapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
        configuration(modelMapper);
        return modelMapper::map;
    }

    private void configuration(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setSourceNamingConvention(NamingConventions.NONE)
                .setDestinationNamingConvention(NamingConventions.NONE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(Customer.class, CustomerOutput.class)
                .addMappings(mapping ->
                        mapping.using(fullNameToFirstNameConverter)
                                .map(Customer::fullName, CustomerOutput::setFirstName))
                .addMappings(mapping ->
                        mapping.using(fullNameToLastNameConverter)
                                .map(Customer::fullName, CustomerOutput::setLastName))
                .addMappings(mapping ->
                        mapping.using(birthDateToLocalDateConverter)
                                .map(Customer::birthDate, CustomerOutput::setBirthDate));

        modelMapper.createTypeMap(OrderPersistenceEntity.class, OrderDetailOutput.class)
                .addMappings(mapping ->
                        mapping.using(longToStringTSIDConverter)
                                .map(OrderPersistenceEntity::getId, OrderDetailOutput::setId));

        modelMapper.createTypeMap(OrderItemPersistenceEntity.class, OrderItemDetailOutput.class)
                .addMappings(mapping ->
                        mapping.using(longToStringTSIDConverter)
                                .map(OrderItemPersistenceEntity::getId, OrderItemDetailOutput::setId))
                .addMappings(mapping ->
                        mapping.using(longToStringTSIDConverter)
                                .map(OrderItemPersistenceEntity::getOrderId, OrderItemDetailOutput::setOrderId));


    }

}
