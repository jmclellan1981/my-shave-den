const sendAuthenticatedRequest = (url, token, method = "GET", body = null) => {
  let request = null;

  if (token) {
    const headers = new Headers();
    headers.append("Authorization", "Bearer " + token);
    headers.append("Content-Type", "application/json");
    const params = {
      headers,
      method
    };
    if (method === "POST" && body) {
      params.body = JSON.stringify(body);
    }
    request = fetch(url, params);
  }
  return request;
};

export { sendAuthenticatedRequest };
