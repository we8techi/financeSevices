package com.we8techi.platform.finance.mapper;

import org.mapstruct.factory.Mappers;

public class LoanAccountMapperFactory {
    public static final LoanAccountMapper INSTANCE = Mappers.getMapper(LoanAccountMapper.class);
}
