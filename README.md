#Test setup for 'Hibernate transitive composite foreign key dependency with embedded entity' Problem

I want to map a existing database (we can't change for now) to Hibernate entities.
But my mapping seems to have a problem with a transitive mapped composite keys I can't overcome.

Caused by: org.hibernate.MappingException: Foreign key (FK246FD874D0837E3B:fluid_sample_label [sample])) must have same number of columns as the referenced primary key (fluid_sample [sampleGroup,pre_post])

FluidSampleLabel has FluidSample as foreign key and as part of its own composite primary key. Hibernate seems to ignore the columns/embedded id mapped by the embedded foreign key entity FluidSample in FluidSampleLabel.






