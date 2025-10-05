import React, { Component } from "react";
import { MapContainer, TileLayer, Marker, Popup, GeoJSON } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from "leaflet";

// Fix Leaflet icon URLs
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl:
    "https://unpkg.com/leaflet@1.9.4/dist/images/marker-icon-2x.png",
  iconUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-icon.png",
  shadowUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-shadow.png",
});

//Your locations
const locations = [
  {
    name: "Istanbul",
    position: [41.0082, 28.9784],
    fact: "Istanbul is the only city that spans two continents: Europe and Asia.",
  },
  {
    name: "Tokyo",
    position: [35.6762, 139.6503],
    fact: "Tokyo is the world’s most populous city, blending tradition and technology.",
  },
];

class iPoints extends Component {
    state = {
        interestPoints: []
    }

    async componentDidMount() {
        const response = await fetch('/api/v1/interestpoint');
        const body = await response.json();
        this.setState({interestPoints: body});
    }

    render(){
      const {interestPoints} = this.state;
      return(
        <Marker>
            L.geoJSON(interestPoints._geometry).addTo(map);
        </Marker>
      /*
        {interestPoints.map((interestPoints, index) => (
          <Marker>
            L.geoJSON(interestPoints._geometry).addTo(map);
          </Marker>
        
          <Marker key={index} position={L.geoJson(interestPoints._geometry).po}>
            <Popup>
              <strong>{interestPoints.title}</strong>
              <br />
              {interestPoints.description}
            </Popup>
          </Marker>
          
        ))}*/
      )
    }
}


export default function Map() {
  return (
    <div style={{ height: "100vh", width: "100%" }}>
     <MapContainer
        center={[43.7145, -79.3832]} // Toronto coordinates
        zoom={11.5}
        scrollWheelZoom={true}
        style={{ height: "100%", width: "100%" }}
    >

        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />

        {iPoints}
      </MapContainer>
    </div>
  );
}
