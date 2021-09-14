package org.example.http.framework.resolver.argument;

import org.example.http.framework.Request;
import org.example.http.framework.annotation.RequestMultiPart;
import org.example.http.framework.annotation.RequestQuery;
import org.example.http.framework.dto.Part;
import org.example.http.framework.exception.UnsupportedParameterException;

import java.io.OutputStream;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

public class RequestMultipartHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
  private final Class<RequestMultiPart> annotation = RequestMultiPart.class;

  @Override
  public boolean supportsParameter(Parameter parameter) {
    return parameter.getType().isAssignableFrom(Part.class) && parameter.isAnnotationPresent(annotation);
  }

  @Override
  public Object resolveArgument(Parameter parameter, Request request, OutputStream response) {
    if (!supportsParameter(parameter)) {
      // this should never happen
      throw new UnsupportedParameterException(parameter.getType().getName());
    }

    final RequestMultiPart annotation = parameter.getAnnotation(this.annotation);
    return Optional
        .ofNullable(
            request.getMultipart().get(annotation.value())
        ).orElseThrow(
            () -> new UnsupportedParameterException(annotation.value())
        );
  }
}
