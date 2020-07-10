package calculator.business.calculation.ws.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import calculator.business.calculation.CalculationService;
import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;

@Path("/calculation")
public class WSCalculationREST
{

    @EJB
    private CalculationApi calculationApi;

    @EJB
    private CalculationService calculationService;

    @GET
    @Path("/calculations")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Calculation> geCalculationsAsXML()
    {
        return calculationApi.findAll();
    }

    @POST
    @Path("/add")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void addCalculation(final Calculation calculation)
    {
        calculationService.solve(calculation);
    }

}
