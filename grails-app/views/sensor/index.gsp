
<%@ page import="domoticus.Sensor" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'sensor.label', default: 'Sensor')}" />
	<title><g:message code="default.index.label" args="[entityName]" /></title>
</head>

<body>

<section id="index-sensor" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${sensorInstanceList}" status="i" var="sensorInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div>
		<bs:paginate total="${sensorInstanceCount}" />
	</div>
</section>
	
<div class="progress">
  <div id="temp" class="progress-bar progress-bar-striped active"  role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="50" style="width: 0%">
    <span class="sr-only">0% Complete</span>
  </div>
</div>

<div class="progress">
  <div id="tempa" class="progress-bar progress-bar-success" style="width: 0%">
    <span class="sr-only">35% Complete (success)</span>
  </div>
  <div id="tempb" class="progress-bar progress-bar-warning progress-bar-striped" style="width: 0%">
    <span class="sr-only">20% Complete (warning)</span>
  </div>
  <div id="tempc" class="progress-bar progress-bar-danger" style="width: 0%">
    <span class="sr-only">10% Complete (danger)</span>
  </div>
</div>

		Temperatura: <span id="divtest"></span>
		<script>
		    $(document).ready(function(){
		        setInterval(function() {
		        	$.get('info',function( data ) {
						$('#divtest').html(data);
						if(data<15){
							$('#tempa').width(data+'%');
							$('#tempb').width(0+'%');
							$('#tempc').width(0+'%');
						} else {
							if(data<25){
								$('#tempa').width(15+'%');
								$('#tempb').width((data-15)+'%');
								$('#tempc').width(0+'%');
							} else {
								$('#tempa').width(15+'%');
								$('#tempb').width(10+'%');
								$('#tempc').width((data-25)+'%');
							}
						}
					});
		        	
		        }, 500);
		    });
		</script>	

</body>

</html>
