<template>
	<div class="about">
		<div>
			<H1>NelleKarstenPark</H1>
			<h2>
				Een attractiepark is een entertainmentbestemming die een breed scala aan attracties, entertainment en activiteiten biedt, ontworpen om bezoekers van alle leeftijden te vermaken. Van opwindende achtbanen en waterglijbanen tot rustigere
				attracties zoals draaimolens en treintjes, attractieparken bieden een mix van spanning, plezier en ontspanning. Naast attracties kunnen parken ook live shows, restaurants, winkels en thematische gebieden hebben om de bezoekerservaring te
				verbeteren. Attractieparken trekken vaak grote aantallen bezoekers uit verschillende delen van de wereld en zijn populaire bestemmingen voor gezinsuitjes, vriendengroepen en toeristen.
			</h2>
		</div>
		<div>
			<img src="../assets/attractiePicture.jpg" alt="Attractie foto" />
		</div>
	</div>
	<div class="contact">
		<div>
			<h1>Contact</h1>
			<h3>Email: DatWeetIkNiet@hotmail.com</h3>
			<h3>GSM: 0365 65 54 65</h3>
			<h3>
				Adres: ergens op de wereld <br />
				3020 Leuven
			</h3>
		</div>
		<div style="overflow: hidden; max-width: 100%; width: 500px; height: 500px">
			<div id="google-maps-display" style="height: 100%; width: 100%; max-width: 100%">
				<iframe style="height: 100%; width: 100%; border: 0" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=Leuven,+België&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8"></iframe>
			</div>
			<a class="the-googlemap-enabler" rel="nofollow" href="https://www.bootstrapskins.com/themes" id="get-data-for-embed-map">premium bootstrap themes</a>
		</div>
	</div>
</template>

<style>
.about {
	margin-top: 50px;
	display: flex;
	align-items: center;
	flex-direction: row;
	align-content: center;
}
.about h2 {
	font-weight: 100;
	margin-right: 20%;
}
.about h1 {
	font-size: 80px;
}
.contact h3 {
	font-weight: 100;
}
.contact {
	display: flex;
	justify-content: space-between;
	margin-top: 90px;
}
.about img {
	width: 100%;
}
</style>
