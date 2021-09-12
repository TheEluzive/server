package org.example.http.framework.resolver.argument;

import org.example.http.framework.Request;
import org.example.http.framework.annotation.RequestHeader;
import org.example.http.framework.annotation.RequestQuery;
import org.example.http.framework.exception.UnsupportedParameterException;

import java.io.OutputStream;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

public class RequestQueryHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
  private final Class<RequestQuery> annotation = RequestQuery.class;

  @Override
  public boolean supportsParameter(Parameter parameter) {
    return parameter.getType().isAssignableFrom(List.class) && parameter.isAnnotationPresent(annotation);
  }

  @Override
  public Object resolveArgument(Parameter parameter, Request request, OutputStream response) {
    if (!supportsParameter(parameter)) {
      // this should never happen
      throw new UnsupportedParameterException(parameter.getType().getName());
    }

    final RequestQuery annotation = parameter.getAnnotation(this.annotation);
    return Optional
        .ofNullable(
            request.getQuery().get(annotation.value())
        ).orElseThrow(
            () -> new UnsupportedParameterException(annotation.value())
        );
  }
}
