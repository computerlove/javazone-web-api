package no.javazone.api.sessions.dto;

import no.javazone.api.links.LinkDTO;

import java.util.ArrayList;
import java.util.List;

public class SessionDetaljerDTO {
    public final String tittel;
    public final String starter;
    public final String stopper;
    public final String niva;
    public final String oppsummering;
    public final String beskrivelse;
    public final List<ForedragsholderDetaljerDTO> foredragsholdere;
    public final List<LinkDTO> links;
    public final String rom;
    public final List<String> nokkelord;
    public final String tiltenktPublikum;

    public SessionDetaljerDTO(
            String tittel,
            String starter,
            String stopper,
            String niva,
            String oppsummering,
            String beskrivelse,
            List<ForedragsholderDetaljerDTO> foredragsholdere,
            List<LinkDTO> links,
            String rom,
            List<String> nokkelord,
            String tiltenktPublikum
    ) {
        this.tittel = tittel;
        this.starter = starter;
        this.stopper = stopper;
        this.niva = niva;
        this.oppsummering = oppsummering;
        this.beskrivelse = beskrivelse;
        this.foredragsholdere = foredragsholdere;
        this.links = links;
        this.rom = rom;
        this.nokkelord = nokkelord;
        this.tiltenktPublikum = tiltenktPublikum;
    }

    private SessionDetaljerDTO() {
        this.tittel = null;
        this.starter = null;
        this.stopper = null;
        this.niva = null;
        this.oppsummering = null;
        this.beskrivelse = null;
        this.foredragsholdere = new ArrayList<>();
        this.links = new ArrayList<>();
        this.rom = null;
        this.nokkelord = new ArrayList<>();
        this.tiltenktPublikum = null;
    }

}
