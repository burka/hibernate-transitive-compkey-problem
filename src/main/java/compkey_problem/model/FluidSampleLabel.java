/**
 *
 * This software is written by arcus(x) GmbH and subject 
 * to a contract between arcus(x) and its customer.
 *
 * This software stays property of arcus(x) unless differing
 * arrangements between arcus(x) and its customer apply.
 *
 * arcus(x) GmbH
 * Hamburg, Germany
 *
 * Tel.: +49 (0)40.333 102 92 
 * Fax.: +49 (0)40.333 102 93 
 * http://www.arcusx.com
 * mailto:info@arcusx.com
 *
 */

package compkey_problem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fluid_sample_label")
public class FluidSampleLabel implements Serializable
{
	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sample_group_id"), @JoinColumn(name = "pre_post")})
	private FluidSample sample;

	@Id
	private String label;

	@SuppressWarnings("unused")
	private FluidSampleLabel()
	{
	}

	FluidSampleLabel(FluidSample sample, String value)
	{
		this.sample = sample;
		this.label = value;
	}

	public String getLabel()
	{
		return this.label;
	}
}
