import React from "react";
import { MapContainer, Marker, Popup, TileLayer } from "react-leaflet";

function Map() {
  return (
    <MapContainer center={[51.505, -0.09]} zoom={4} scrollWheelZoom={true}>
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <Marker position={[51.505, -0.09]}>
        <Popup>London — Capital of the UK</Popup>
      </Marker>
    </MapContainer>
  );
}

export default Map;   // ✅ VERY important!
