<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- Body -->
		<div class="container contentWraper">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- Footer -->
		<tiles:insertAttribute name="footer" />
	</body>
</html>