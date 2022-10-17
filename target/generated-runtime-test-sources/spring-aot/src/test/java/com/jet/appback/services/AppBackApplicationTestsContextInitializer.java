package com.jet.appback.services;

import com.jet.appback.repository.NuserRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class AppBackApplicationTestsContextInitializer {
  public static void registerNuserService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("nuserService", NuserService.class)
        .instanceSupplier((instanceContext) -> {
          NuserService bean = new NuserService();
          instanceContext.field("nuserRepository", NuserRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field nuserRepositoryField = ReflectionUtils.findField(NuserService.class, "nuserRepository", NuserRepository.class);
                ReflectionUtils.makeAccessible(nuserRepositoryField);
                ReflectionUtils.setField(nuserRepositoryField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }
