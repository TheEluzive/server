package org.example.http.framework;

import lombok.Builder;
import lombok.Value;
import org.example.http.framework.dto.Part;

import java.util.List;
import java.util.Map;

@Value
@Builder
public class Request {
  String method;
  String path;
  // TODO: query
  Map<String, String> headers;
  Map<String, List<String>> query;
  Map<String, List<String>> form;
  Map<String, Part> multipart;
  @Builder.Default
  byte[] body = new byte[]{};
}
