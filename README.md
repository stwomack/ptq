# mastercard-ess-processed-transactions-query
Holds Mastercard POT query for GPDB simulation

# Continuous Delivery

## Installing via Concourse
Everything needed to install this service via concourse (pipeline service) is avaialble under the ci folder.

### Step 1 Edit pipeline.yml to reflect Source Repo
You will first need to modify the following file and key to reflect the source repo concourse is pulling from
```
# ci/pipeline.yaml

- name: source-code
  type: git
  source:
    uri: https://github.com/Anthonyhawkins/mastercard-ess-processed-transactions-query.git
    branch: master
```

### Step 2 Clone this repo to the Concourse CLI Host
Concourse Pipelines are installed via a CLI command NOT a GUI.  In order to install this servcie log into the server which
has installed the concourse CLI

```
git clone https://github.com/Anthonyhawkins/mastercard-ess-processed-transactions-query.git
cd mastercard-ess-processed-transactions-query
```

### Step 3 Modify the cd-env.yaml file with needed configuration information
the cf-env.yaml file provided within this repo is an example of the information needed to install the pipeline.
you must first rename the file to be .cf-env.yaml as this is what concoruse CLI will look for when installing.

### Step 4 Install Concourse fly CLI, and run ci/fly.sh
Look at the script & assert that your concourse endpoint, and user auth (-u|-p) are properly configured for your concourse environment.
