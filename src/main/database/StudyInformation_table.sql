CREATE TABLE StudyInformation(
	SI_S_INDEX NUMBER NOT NULL,
	SI_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SI_S_INDEX, SI_M_INDEX)
)

ALTER TABLE StudyInformation ADD FOREIGN KEY(SI_S_INDEX) REFERENCES Study(S_INDEX);
ALTER TABLE StudyInformation ADD FOREIGN KEY(SI_M_INDEX) REFERENCES Member(M_INDEX);

SELECT SI_S_INDEX, SI_M_INDEX FROM StudyInformation;
INSERT INTO StudyInformation(SI_S_INDEX, SI_M_INDEX) VALUES (?, ?);
UPDATE StudyInformation SET SI_S_INDEX=?, SI_M_INDEX=? WHERE SI_S_INDEX=? AND SI_M_INDEX=?;
DELETE FROM StudyInformation WHERE SI_S_INDEX=? AND SI_M_INDEX=?;