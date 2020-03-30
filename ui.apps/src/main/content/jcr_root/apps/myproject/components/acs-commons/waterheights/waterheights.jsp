<%--
  #%L
  ACS AEM Commons Package
  %%
  Copyright (C) 2013 Adobe
  %%
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  #L%
  --%>
<%@include file="/libs/foundation/global.jsp" %>

<li>
    <%
        String dateField = properties.get("datefield", "");
        String height = properties.get("height", "");
        
        if (dateField.equals("")) {
    %><span style="color: red;">Please enter Validity Period Description</span>
    <%
    } else if (height.equals("")) {
    %><span style="color: orangered;">Please enter Validity Period </span>

   <% } else {
    %>
    Date: <%=dateField%> <br/>
    Height in cm: <%=height%> <br/>
    <%}%>
</li>
